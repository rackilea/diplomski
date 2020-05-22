Integer checkNumber = queue.take();
if (checkNumber == NumberEnumerationTask.DUMMY) {
    queue.put(checkNumber);
    done = true;
} else {
    checkPrimeNumber(checkNumber);
}