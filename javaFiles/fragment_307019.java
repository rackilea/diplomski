boolean isSomeThing:
if ((isSomeThing = object instanceof SomeThing) || object instanceof OtherThing) {
    System.out.println("Got here because it's " +
        isSomeThing ? "SomeThing" : "OtherThing")
    );
}