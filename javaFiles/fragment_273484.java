public function showItemsByCategoryAction($categoryName) {
  $service = new Item_CategoryName_Finder_Service();
  $items = $service->find($categoryName);

  if(empty($items)){
    //@TODO show empty page result, redirect or whatever
  }

  $this->getView()->bind('items', $items);
}