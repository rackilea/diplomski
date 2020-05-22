public interface AssessmentDao {
  CommentBO getComment(Integer clientNumber, Integer commentCategory);
}

public class AssessmentDaoImpl implements AssessmentDao {
  @Override
  public CommentBO getComment(Integer clientNumber, Integer commentCategory) {
    throw new AssertionError("Should not be called");
  }
}

public interface AssessmentService {
  CommentBO getComment(Integer clientNumber, Integer commentCategory);
}

public class AssessmentServiceImpl implements AssessmentService {

  private AssessmentDao assessmentDao;

  @Override
  public CommentBO getComment(Integer clientNumber, Integer commentCategory) {
    CommentBO comment = this.assessmentDao.getComment(clientNumber, commentCategory);

    if (comment != null && comment.getComments() != null) {
      comment.setComments(comment.getComments().replaceAll("<li>&bull;", "<li>"));
    }

    return comment;
  }
}

public class CommentBO {

  public static CommentBO createNewComment(Integer clientNumber, Integer commentCategory) {
    CommentBO bo = new CommentBO();
    bo.setClientNumber(clientNumber);
    bo.setCommentCategory(commentCategory);
    return bo;
  }

  private Integer clientNumber;
  private Integer commentCategory;
  private String comments;

  public Integer getClientNumber() {
    return clientNumber;
  }

  public void setClientNumber(Integer clientNumber) {
    this.clientNumber = clientNumber;
  }

  public Integer getCommentCategory() {
    return commentCategory;
  }

  public void setCommentCategory(Integer commentCategory) {
    this.commentCategory = commentCategory;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}

public class ReflectionTestUtils {

  public static void setField(Object object, String fieldName, Object value) {
    try {
      Field field = object.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      field.set(object, value);
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
}

public class AssessmentServiceTest   {

  public AssessmentService assessmentService = new AssessmentServiceImpl();

  @Test
  public void testGetComment(){

    Integer clientNumber = 1;
    Integer commentCategory = 1;
    CommentBO commentBO = CommentBO.createNewComment(clientNumber, commentCategory);

    AssessmentDao assessmentDao = EasyMock.createMock(AssessmentDao.class);

    expect(assessmentDao.getComment(anyObject(), anyObject())).andReturn(commentBO);

    ReflectionTestUtils.setField(assessmentService, "assessmentDao", assessmentDao);

    replay(assessmentDao);

    CommentBO bo = assessmentService.getComment(clientNumber, commentCategory);

    verify(assessmentDao);

    assertThat(bo , instanceOf(CommentBO.class));
  }

}