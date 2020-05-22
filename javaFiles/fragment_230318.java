@Override
public Integer countUOW(Object args) {
    for (Object arg : (List<?>) args) {
        total += uowProcessor.countUOW(arg);
    }

    return total;
}