@MessageDriven(
    mappedName = "jms/someName",
    activationConfig = {
        ... ,
        @ActivationConfigProperty(
            propertyName = "messageSelector",
            propertyValue = ConstantStrings.CONST1 
                            + " = '"
                            + ConstantStrings.CONST2
                            + "'"
        )
    }
) // this one