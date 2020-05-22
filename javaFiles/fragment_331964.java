@RequestMapping(value = "/create", method = RequestMethod.POST)
    public Node create(@Valid @RequestBody Node node, BindingResult bindingResult) {
        LOG.info(String.format("Create new Node: %s", node));
        if (!bindingResult.hasErrors()) {
            return nodeService.create(node);
        } else {
            return null;
        }
    }