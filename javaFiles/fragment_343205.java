@SaveTransaction
@Transactional
public synchronized Transaction move(@NonNull String accountName, @NonNull String destinationName, @NonNull BigDecimal amount, String comment) {
    checkAmountIsPositive(amount);

    Account donor = getAccount(accountName);
    Account acceptor = getAccount(destinationName);

    if (!isEnoughAmount(accountName, amount)) throw new NotEnoughAmountInAccountException();

    BigDecimal newDonorAmount = donor.getAmount().add(amount.negate());
    BigDecimal newAcceptorAmount = acceptor.getAmount().add(amount);

    donor.setAmount(newDonorAmount);
    acceptor.setAmount(newAcceptorAmount);

    accountRepository.save(donor);
    accountRepository.save(acceptor);

    return null;
}