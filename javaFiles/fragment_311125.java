with open('input.txt') as f:
    isBeta = False
    beta = {}
    alpha = {}
    for line in f:
        if line.strip() == 'Beta:':
            isBeta = True
            continue
        elif line.strip() == 'Alpha:' or not line.strip():
            continue


        try:
            k,v = line.split()
        except:
            continue
        if isBeta:
            beta[k] = v
        else:
            alpha[k] =  v

    for k in sorted(set(alpha.keys()+beta.keys())):
        if k not in alpha:
            print '| -- | ' + k + '=' + beta[k] + '|'
        elif k not in beta:
            print '|' + k + '=' + alpha[k] + ' | -- |'
        elif alpha[k] == beta[k]:
            continue
        else:
            print '|' + k + '=' + alpha[k] + ' | ' + k + '=' + beta[k] + '|'