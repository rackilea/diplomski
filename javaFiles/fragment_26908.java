import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

    @Test
    public void testnewEmployeePost() throws Exception{


        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setPanCardNo("lower");
        employeeDetails.setFirstName("Nitesh");

        mockMvc.perform(post("/manager/new")
            .with(user("nitesh")
            .password("nitesh")
            .authorities(AuthorityUtils.createAuthorityList("ROLE_USER"))
        .contentType(MediaType.ALL)
        .sessionAttr("employeeDetails", employeeDetails))   
        .andExpect(model().attribute("employeeDetails", instanceOf(EmployeeDetails.class)));
    }