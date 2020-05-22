public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader classLoader, String s, Class<?> aClass, ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {
                if ("your/package/Trade".equals(s)) {
                    try {
                        ClassPool cp = ClassPool.getDefault();
                        CtClass ctClass = cp.get("your.package.Trade");
                        CtMethod commandMethod = ctClass.getDeclaredMethod("log");
                        commandMethod.setBody("if (/* conditions */) {"
                            + "    fw.write(sender + \" [\" + senderUser.getMoney() + \"/\" + senderOldBal + \"] sent \" + pay.getMoney() + \" to \" + receiver + \"[\" + receiverOldBal + \"/\" + receiverUser.getMoney() + \"]\");"
                            + "}");
                        byte[] byteCode = ctClass.toBytecode();
                        ctClass.detach();
                        return byteCode;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

}