@Override
    public Optional<InvoiceFaDTO> findOneWithLines(long id) {
        Optional<Invoice> i = invoiceFaRepository.findById(id);
        i.ifPresent(invoice -> {
            if (invoice.getAttachmentUrl() != null) {
                invoice.setPdf(amazonService.downloadFile(invoice.getAttachmentUrl()).toByteArray());
            }
        });
        return i.map(invoiceFaMapper::toDto);
    }