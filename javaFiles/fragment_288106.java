while (there are parentheses left) {
    find first closing parenthesis;
    walk left and find nearest opening parenthesis;
    evaluate expression inbetween;
    replace expression with result and remove parentheses;
}
evaluate expression;