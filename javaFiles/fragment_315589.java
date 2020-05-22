Page<User> customers = userRepository.findByReferenceNo(agent.getReferenceNo(),
            new PageRequest(page, PageAttr.PAGE_SIZE));

Page<UserDto> userDtos = customers.map(c -> customerMapper.customerResponseMapper(c));

return userDtos;