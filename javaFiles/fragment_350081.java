class StackOverflow {
    public static void main(String[] args) {
        String source = "Logger.getInstance(JdkUtil.forceInit(RtpRuleEngineCompiledImpl.class))";
        String regexpPattern = "JdkUtil.forceInit\\(([a-zA-Z_0-9]*.class)\\)";
        String replaced = source.replaceFirst(regexpPattern, "$1");
        System.out.println(replaced);
    }
}