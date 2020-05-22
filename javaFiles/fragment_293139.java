Question q = new Question();
for (int i=0; i<2; i++) {
    q.executeGlobal();
    q.executeStatic();
    q.executeLocal();
}