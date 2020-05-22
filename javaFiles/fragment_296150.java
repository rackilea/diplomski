Waiter newWork = new Waiter(email, password, name, surname, bithday, shoeSize, dressSize,new Role(role));

GuestOrder order1 = new GuestOrder();
GuestOrder order2 = new GuestOrder();

order1.setWaiter(newWork);
order2.setWaiter(newWork);

newWork.addActiveOrder(order1);
newWork.addActiveOrder(order2);

repository.flush();
return repository.save(newWork);