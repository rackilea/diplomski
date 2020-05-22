@Test
    public void testAddOrg() {

        final Organization expectedOrg = new Organization();
        expectedOrgAttr.setId("7c82facc");
        expectedOrgAttr.setKeys("one");

        new Expectations() {{
            mockJdbcTemplate.queryForObject(DAOImpl.GET_KEY_FOR_ORG_IDS, (DAORowMapper) any, expectedOrgAttr.getId(), expectedOrgAttr.getKeys());
            result = expectedOrgAttr;
        }};

        Organization actualKey =daoImpl.addOrg(expectedOrgAttr.getId(), expectedOrgAttr.getKeys());
        assertEquals(expectedOrgAttr.getId(), actualKey.getId());
    }