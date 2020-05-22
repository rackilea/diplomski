function expandCollapseFolder(event, folder) {
    var list = folder.down('ul');
    if (list) list.toggle();
    else new Ajax.Updater(folder, 'URL-OF-SERVER-PAGE',
    {
        parameters: { path: folder.readAttribute('data-path') },
        insertion: 'bottom'
    });
}

Event.on('ID-OF-FILE-BROWSER', 'click', 'li.folder', expandCollapseFolder);