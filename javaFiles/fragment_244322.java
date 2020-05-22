public aspect NamingConventionsAspect {
    pointcut methodWith0() : execution(* *.*0*(..));
    pointcut methodWith1() : execution(* *.*1*(..));
    pointcut methodWith2() : execution(* *.*2*(..));
    pointcut methodWith3() : execution(* *.*3*(..));
    pointcut methodWith4() : execution(* *.*4*(..));
    pointcut methodWith5() : execution(* *.*5*(..));
    pointcut methodWith6() : execution(* *.*6*(..));
    pointcut methodWith7() : execution(* *.*7*(..));
    pointcut methodWith8() : execution(* *.*8*(..));
    pointcut methodWith9() : execution(* *.*9*(..));
    pointcut readFieldWith0() : get(* *.*0*);
    pointcut readFieldWith1() : get(* *.*1*);
    pointcut readFieldWith2() : get(* *.*2*);
    pointcut readFieldWith3() : get(* *.*3*);
    pointcut readFieldWith4() : get(* *.*4*);
    pointcut readFieldWith5() : get(* *.*5*);
    pointcut readFieldWith6() : get(* *.*6*);
    pointcut readFieldWith7() : get(* *.*7*);
    pointcut readFieldWith8() : get(* *.*8*);
    pointcut readFieldWith9() : get(* *.*9*);
    pointcut setFieldWith0() : set(* *.*0*);
    pointcut setFieldWith1() : set(* *.*1*);
    pointcut setFieldWith2() : set(* *.*2*);
    pointcut setFieldWith3() : set(* *.*3*);
    pointcut setFieldWith4() : set(* *.*4*);
    pointcut setFieldWith5() : set(* *.*5*);
    pointcut setFieldWith6() : set(* *.*6*);
    pointcut setFieldWith7() : set(* *.*7*);
    pointcut setFieldWith8() : set(* *.*8*);
    pointcut setFieldWith9() : set(* *.*9*);
    pointcut classWith0() : within(*0*);
    pointcut classWith1() : within(*1*);
    pointcut classWith2() : within(*2*);
    pointcut classWith3() : within(*3*);
    pointcut classWith4() : within(*4*);
    pointcut classWith5() : within(*5*);
    pointcut classWith6() : within(*6*);
    pointcut classWith7() : within(*7*);
    pointcut classWith8() : within(*8*);
    pointcut classWith9() : within(*9*);

    declare error : methodWith0() || methodWith1() || methodWith2() || methodWith3() || methodWith4() || 
    methodWith5() || methodWith6() || methodWith7() || methodWith8() || methodWith9() || readFieldWith0() || 
    readFieldWith1() || readFieldWith2() || readFieldWith3() || readFieldWith4() || readFieldWith5() || 
    readFieldWith6() || readFieldWith7() || readFieldWith8() || readFieldWith9() || setFieldWith0() || 
    setFieldWith1() || setFieldWith2() || setFieldWith3() || setFieldWith4() || setFieldWith5() || setFieldWith6() || 
    setFieldWith7() || setFieldWith8() || setFieldWith9() || classWith0() || classWith1() || classWith2() || 
    classWith3() || classWith4() || classWith5() || classWith6() || classWith7() || classWith8() || classWith9() : 
        "Identifiers shouldn't contain numbers!";
}