public Animal breed() {
    try {
        return (Animal) getClass().newInstance();
    } catch (Exception ex) {
        // TODO Log me
        return null;
    }
}