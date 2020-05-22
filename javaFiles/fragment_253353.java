if (this.saltGenerator.includePlainSaltInEncryptionResults()) {
        // Check that the received message is bigger than the salt
        if (encryptedMessage.length <= this.saltSizeBytes) {
            throw new EncryptionOperationNotPossibleException();
        }
}