rule "straight As1"
when
    $s : Student( grades != null, $g : grades )
    not Semester(reading != "A" || writing != "A" || math != "A") from $g
then
    System.out.println($s.getId() + ": s all As1: " + $s);
    System.out.println($s.getId() + ": g all As1: " + $g);
end