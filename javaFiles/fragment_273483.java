public function showItemsByCategoryAction($categoryName) {
  $categoryId = $categoryDAO->findByName($categoryName);
  if(is_null($categoryId)) {
    //@TODO error
  }

  $itemIds = $categoryLinkDAO->getItemsByCategoryId($categoryId);
  if(empty($itemIds)) {
    //@TODO show error to the user
  }

  $items = $categoryItemDAO->findManyItems($itemIds);

  //@TODO parse, assign to view etc
}