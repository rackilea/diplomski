void diamond(stars, spaces) {
    if (n == 0) {
        print(' ' * spaces)
    } else {
        print('*' * stars, ' ' * spaces, '*' * stars)
        diamond(stars - 1, spaces + 2)
        print('*' * stars, ' ' * spaces, '*' * stars)
    }
}