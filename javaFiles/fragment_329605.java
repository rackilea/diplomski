@Override
public List<Integer> doInBackground() {
    while (! enough && ! isCancelled()) {
            number = nextPrimeNumber();
            publish(number);
            setProgress(100 * numbers.size() / numbersToFind);
        }
    }
    return numbers;
}