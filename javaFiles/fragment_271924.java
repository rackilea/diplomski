cur = -1
lnq = ln(q)
while true
    u = random(0,1)   // float!
    cur = cur + 1 + floor(ln(u)/lnq)
    if cur >= MAX
        break
    randomNumbersList.add(cur);