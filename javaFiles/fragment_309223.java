Set<E> result = new HashSet<>();
Set<E> appeared = new HashSet<>();

for (E element : elements) {
    if (result.contains(element)) { // 2nd occurrence
        result.remove(element);
        appeared.add(element);
        continue;
    }
    if (appeared.contains(element)) { // >2nd occurrence
        continue;
    }

    result.add(element); // 1st occurrence
}