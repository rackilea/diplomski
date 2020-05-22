interface Model {

  }

  abstract class AbstractModel<P extends Model> implements Model {

    Long id;
    P    parent;
  }

  class ProjectModel extends AbstractModel implements HasFileModel,
      HasFolderModel {

  }

  interface HasFileModel extends Model {
  }

  static class FileModel extends AbstractModel<HasFileModel> {

  }

  interface HasFolderModel extends Model {

  }

  class FolderModel extends AbstractModel<HasFolderModel> implements
      HasFileModel {

  }