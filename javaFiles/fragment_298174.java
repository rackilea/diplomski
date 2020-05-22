rule "PrintNameWhenAgeWhenGreaterThan18"
 dialect "mvel"
 when
    $data : Map( age > 18 )
 then
    System.out.println($data.name);
end