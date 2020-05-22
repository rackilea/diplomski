from("queue:start").
  choice().xpath("//foo")).to("queue:taskB").
  otherwise().to("queue:taskA");

from("queue:taskB").process(new DoTaskB()).to("queue:taskA");

from("queue:taskA").process(new DoTaskA()).to("queue:done");