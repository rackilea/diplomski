public static void main(String[] args) throws Exception {
    A4Reporter rep = new A4Reporter();

    A4Options options = new A4Options();
    options.solver = A4Options.SatSolver.MiniSatProverJNI;

    Module someWorld = CompUtil.parseEverything_fromFile(rep, null, "someFile.als");
    Command command = someWorld.getAllCommands().get(0);
    A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, someWorld.getAllReachableSigs(), command, options);
    System.out.println(ans);

    Module someOtherWorld = CompUtil.parseEverything_fromFile(rep, null, "someOtherFile.als");
    Command commandTwo = someOtherWorld.getAllCommands().get(0);
    A4Solution ansTwo = TranslateAlloyToKodkod.execute_command(rep, someOtherWorld.getAllReachableSigs(), commandTwo, options);
    System.out.println(ansTwo);
}