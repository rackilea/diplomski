InstallLinkJoined installLinkJoined = installLinkJoinedService.getInstallLinkWithID(installLink);
if (installLinkJoined != null) {
    model.addAttribute("install", installLinkJoined);
} else {
    model.addAttribute("install", new InstallLinkJoined());
}