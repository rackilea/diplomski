private PinRepository pinRepository;

PinViewModel(@NonNull PinRepository pinRepository) {
    this.pinRepository = pinRepository;
}

public LiveData<List<Pin>> getPins() {
    return pinRepository.getPins();
}