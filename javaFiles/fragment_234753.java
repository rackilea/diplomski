rabbitConnFactory = new ConnectionFactory();
rabbitConnFactory.setHost("localhost");
final Connection conn = rabbitConnFactory.newConnection();
final Channel channel = conn.createChannel();

// declare a direct, durable, non autodelete exchange named 'tasks'    
channel.exchangeDeclare("tasks", "direct", true); 
// declare a durable, non exclusive, non autodelete queue named 'task_queue'
channel.queueDeclare("task_queue", true, false, false, null); 
// bind 'task_queue' to the 'tasks' exchange with the routing key 'camel'
channel.queueBind("task_queue", "tasks", "camel");