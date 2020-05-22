rule "twoInARowIsgood"
when
    CourseSequentialRequirement($c : course)
    Lecture (course == $c, $firstP : period)
    Lecture (course == $c, period.isImmediatlyAfter($firstP))
then
    scoreHolder.add...(kcontext, 100); // Positive constraint
end

rule "threeInARowIsBad"
when
    CourseSequentialRequirement($c : course)
    Lecture (course == $c, $firstP : period)
    Lecture (course == $c, period.isImmediatlyAfter($firstP), $secondP : period)
    Lecture (course == $c, period.isImmediatlyAfter($secondP))
then
    scoreHolder.add...(kcontext, -500); // Negative constraint and higher than twice the positive one
end