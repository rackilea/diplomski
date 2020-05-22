with open('input.txt') as f:
    indent = 8
    prev_depth = -1
    closes = []
    for line in f:
        line = line.strip()
        if not line: continue

        depth = line.count('|')
        while prev_depth >= depth:
            prev_depth -= 1
            print(closes.pop())
        pad = ' ' * (depth*indent)
        print(pad + 'If ({})'.format(line.lstrip('| ').split(':', 1)[0]))
        print(pad + '{')
        closes.append(pad + '}')
        if ':' in line:
            pad2 = ' ' * ((depth+1)*indent)
            print(pad2 + 'Return {}'.format(line[line.find(':')+1:].strip()))
        prev_depth = depth
    while closes:
        print(closes.pop())