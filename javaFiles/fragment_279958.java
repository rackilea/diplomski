labelWorking.textProperty().bind(
    selectedItemBinding
    .flatMap(ModelItem::detailsProperty)
    .map(l -> derivedBinding(l))
    .flatMap(l -> EasyBind.combine(
             l, stream -> stream.collect(Collectors.joining(", "))))
    );