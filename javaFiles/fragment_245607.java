Notification<MyModel> addAction = service.addMyModel(myModelDTO);
if (addAction.hasErrors()) {
    model.addAttribute("myModel", addAction.getModel());
    model.addAttribute("notifications", addAction.getAllErrors());
    return "myModelView"; // no redirect if errors
} 
redirectAttrs.addFlashAttribute("success", "My Model was added successfully");
return "redirect:/thepage";