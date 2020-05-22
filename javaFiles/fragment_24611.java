boolean success = false;
try {
  reportStartWorkflow();
  doThis();
  doThat();
  workHarder();
  success = true;
} finally {
  if (!success) System.out.println("No success");
}