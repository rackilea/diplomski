// Now this method accept the MenuModel#id property
patchItAdd(menuId: number, name: string, price: number){
   if (!name) {
      return;
   }

   const trimmedName = name.trim();

   // Construct a new ItemClass instance.
   // You need to take care by yourself of the "person" property and the "quantity" property
   const newItem = new ItemClass("", trimmedName, 0, price)

   this.menuService.patchAdd(menuId, newItem).subscribe(item => {
      this.items.push(item);
   });
}