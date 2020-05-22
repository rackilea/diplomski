@Test
        public void testGetHomePageCollection() {
            when(collectionService.getHomePageCollections()).thenReturn(null);

            ResponseEntity responseEntity = collectionController.getHomePageCollections(HEADER_APP_TOKEN);
            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
            assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        }