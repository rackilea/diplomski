Page<Player> pageStub = (Page<Player>)Mockito.mock(Page.class);
Mockito.when(playerRepository.findByNameContainingIgnoreCase(name, pageableStub))
            .thenReturn(pageStub);

Page<PlayerStub> result = playerService.listPlayersByName(name, pageableStub);

assertSame(pageStub, result);

// No need to call verify, since it couldn't get pageStub without calling the correctly stubbed method.