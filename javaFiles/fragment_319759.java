filterExpression returns [ActivityPredicate pred]
    : n=NAME o=OPERATOR (p=PACE | i=NUMBER) {
        if ($PACE != null) {
            $pred = new SingleActivityPredicate(
                $n.text, Operator.fromCharacter($o.text), $p.text);
        } else {
            $pred = new SingleActivityPredicate(
                $n.text, Operator.fromCharacter($o.text), $i.text);
        }
    };