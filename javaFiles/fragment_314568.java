@Test
    public void testFindByIdForPartitionedCollection() {
        final List<Address> addresses = repository.findByPostalCode(TestConstants.POSTAL_CODE);

        assertThat(addresses.size()).isEqualTo(2);
        assertThat(addresses.get(0).getPostalCode().equals(TestConstants.POSTAL_CODE));
        assertThat(addresses.get(1).getPostalCode().equals(TestConstants.POSTAL_CODE));
    }