void treeWalk(root):
    treeWalk(root, []);

void treeWalk(root, conditions):
    case root of:
        If(cond, positive, negative):
            if (positive is not null):
                treeWalk(positive, conditions + cond)
            if (negative is not null):
                treeWalk(negative, conditions + !cond)
        Sequence(statements):
            for each statement in statements:
                treeWalk(statements, conditions)
        Terminal:
            print "IF "
            for each condition in conditions:
                if (condition is not the last condition):
                    print " AND "
                print condition