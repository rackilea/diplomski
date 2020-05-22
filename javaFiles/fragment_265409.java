final RadioGroup<Integer> radioGroup1 = new RadioGroup<Integer>("radioGroup1", new Model<Integer>());
final RadioGroup<Integer> radioGroup2 = new RadioGroup<Integer>("radioGroup2", new Model<Integer>());
final RadioGroup<Integer> radioGroup3 = new RadioGroup<Integer>("radioGroup3", new Model<Integer>());
final RadioGroup<Integer> radioGroup4 = new RadioGroup<Integer>("radioGroup4", new Model<Integer>());

add(new FeedbackPanel("feedback"));
add(new Form<Void>("form")
    .add(radioGroup1
        .add(radioGroup2
            .add(radioGroup3
                .add(radioGroup4
                    .add(new Loop("loop", 10) {
                        @Override
                        protected void populateItem(LoopItem item) {
                            Model<Integer> itemModel = Model.of(item.getIndex());
                            item.add(new Radio<Integer>("radio1", itemModel, radioGroup1));
                            item.add(new Radio<Integer>("radio2", itemModel, radioGroup2));
                            item.add(new Radio<Integer>("radio3", itemModel, radioGroup3));
                            item.add(new Radio<Integer>("radio4", itemModel, radioGroup4));
                            item.add(new Label("label", itemModel));
                        }
                    })))))
    .add(new Button("submit") {
        @Override
        public void onSubmit() {
            info(Strings.join(", ",
                radioGroup1.getModelObject().toString(),
                radioGroup2.getModelObject().toString(),
                radioGroup3.getModelObject().toString(),
                radioGroup4.getModelObject().toString()));
        }
    }));



<div wicket:id="feedback"></div>

<form wicket:id="form">

  <div wicket:id="radioGroup1">
  <div wicket:id="radioGroup2">
  <div wicket:id="radioGroup3">
  <div wicket:id="radioGroup4">

    <table>
      <tr>
        <th>A</th>
        <th>B</th>
        <th>C</th>
        <th>D</th>
      </tr>
      <tr wicket:id="loop">
        <td><input type="radio" wicket:id="radio1"></td>
        <td><input type="radio" wicket:id="radio2"></td>
        <td><input type="radio" wicket:id="radio3"></td>
        <td><input type="radio" wicket:id="radio4"></td>
        <td><span wicket:id="label"></span></td>
      </tr>
    </table>

  </div>
  </div>
  </div>
  </div>

  <button wicket:id="submit" type="submit">Submit</button>

</form>