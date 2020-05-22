public Single<List<MenuItemsBlocks>> loadMenuItemsBlocks() {

    return Completable.fromAction(() -> DataStoreRepository.deleteMenuItemsBlock())
        .subscribeOn(Schedulers.io())
        .andThen(Single.defer(() -> {
            Set<String> aliasList = getAliasFromMenuItems();

            return Observable.fromIterable(aliasList)
                .concatMap(alias -> ApiRepository.getMenuItemBlocks(alias)
                    .subscribeOn(Schedulers.io())
                    .flatMapIterable(list -> list)
                    .map(item -> new MenuItemsBlocks(
                        item.getId(),
                        item.getType(),
                        item.getImagePosition(),
                        item.getTextField(),
                        item.getSortOrder(),
                        item.getFileTimeStamp(),
                        alias
                    ))
                    .doOnNext(block -> DataStoreRepository.saveMenuItemsBlock(block))
                    .subscribeOn(Schedulers.io())
                )
                .toList();
      }));
}