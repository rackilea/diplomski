private String getShortcutDescription() {
    Binding bestBinding = null;
    for (Binding binding : getViewSite().getService(IBindingService.class).getBindings()) {
        if (binding.getParameterizedCommand() != null
                && "notepad4e.command.text.bold".equals(binding.getParameterizedCommand().getId())) {
            if (bestBinding == null) {
                bestBinding = binding;
            } else if (binding.getType() == Binding.USER) {
                // Give higher priority to a user type binding (user has overriden default).
                bestBinding = binding;
                break;
            }
        }
    }
    return bestBinding == null ? "" : " " + bestBinding.getTriggerSequence().format();
}