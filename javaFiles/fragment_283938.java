public interface IBusiness<Model, VO> {

    public Model toModel(VO vo);
    public VO toVO(Model model);
    public List<Model> toModelList(List<VO> vos);
    public List<VO> toVOList(List<Model> models);

}