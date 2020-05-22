INF = 100000000000

pickup = {}
dest = {}
trace = {}
dp = {}

def calc(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

def solve(curPos, completed, ongoing):
    if len(completed) == N and len(ongoing) == 0:
        return 0
    curState = (curPos, frozenset(completed), frozenset(ongoing))   

    if curState in dp.keys():
        return dp[curState]

    minVal = INF
    for i in pickup.keys():
        if i in completed: continue
        newOngoing = ongoing.copy()
        newCompleted = completed.copy()

        if i in ongoing:
            newOngoing.remove(i)
            newCompleted.add(i)
            val = calc(curPos, dest[i]) + solve(dest[i], newCompleted, newOngoing)
            if val < minVal:
                minVal = val
                trace[curState] = \
                    ("drop " + str(i), (dest[i], newCompleted, newOngoing))
        elif len(ongoing) < maxCustomers:
            newOngoing.add(i)
            val = calc(curPos, pickup[i]) + solve(pickup[i], newCompleted, newOngoing)
            if val < minVal:
                minVal = val
                trace[curState] = \
                    ("pickup " + str(i), (pickup[i], newCompleted, newOngoing))

    dp[curState] = minVal
    return minVal

def path(state):
    stateVar = (state[0], frozenset(state[1]), frozenset(state[2]))
    if stateVar not in trace.keys():
        return
    print (trace[stateVar][0])
    if trace[stateVar][1] != None: 
        return path(trace[stateVar][1])

maxCustomers = int(input())
rstr = input().split(",")
start = (int(rstr[0]), int(rstr[1]))
N = int(input())
for i in range(N):
    line = input().split(",")
    pickup[int(line[0])] = (int(line[1]), int(line[2]))
    dest[int(line[0])] = (int(line[3]), int(line[4]))

print("Total distance travelled: ", solve(start, set(), set()))
path((start, set(), set()))