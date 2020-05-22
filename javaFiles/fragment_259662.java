interface ItemRequestConverter<IR extends ItemRequest> {
    Target convert(IR request);
}

interface CreateItemRequestConverter<CIR extends CreateItemRequest>
        extends ItemRequestConverter<CIR> {

}

class CreatePartRequestConverter implements CreateItemRequestConverter<CreatePartRequest> {
    @Override
    public Target convert(CreatePartRequest request) {
        return null;
    }
}

class ItemRequest {
}

class CreateItemRequest extends ItemRequest {
}

class CreatePartRequest extends CreateItemRequest {
}

class Target {
}