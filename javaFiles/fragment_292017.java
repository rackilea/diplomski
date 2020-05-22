@Mapper(uses = { CustomerService.class })
public interface FirstDomainMapper extends EntityMapper<FirstDomainDTO, FirstDomain> {

    @Mapping(source = "customers", target = "customers")
    FirstDomainDTO toDto(FirstDomain firstDomain);

    @Mapping(source = "customers", target = "customers")
    FirstDomain toEntity(FirstDomainDTO firstDomainDTO);

    default String fromCustomer(Customer customer) {
        return customer == null ? null : customer.getCode();
    }

    default Customer fromStringToCustomer(String customerId) {
        // Implement your custom mapping logic here
    }
}