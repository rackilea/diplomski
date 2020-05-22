public static List<CustomerDTO> leftJoin(List<Customers> customers, List<Address> addresses) {
    Map<Integer, Address> aidAddress = addresses.stream().collect(Collectors.toMap(Address::getAid, Function.identity()));

    return customers.stream()
                    .map(customer -> {
                        CustomerDTO customerDto = new CustomerDTO();
                        // set all fields from customer -> customerDto

                        Address address = aidAddress.get(customer.getAid());

                        if (address != null) {
                            AddressDTO addressDto = new AddressDTO();
                            // set all fields from address -> addressDto
                            customerDto.setAddress(addressDto);
                        }

                        return customerDto;
                    })
                    .collect(Collectors.toList());
}