// in jForm1
private static Variables variables = new Variables();
public static getVariables() {
    return variables;
}

// in jForm2
Variables variables = jForm1.getVariables();